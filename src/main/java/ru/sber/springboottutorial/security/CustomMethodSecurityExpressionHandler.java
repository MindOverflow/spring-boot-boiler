package ru.sber.springboottutorial.security;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;

public class CustomMethodSecurityExpressionHandler extends DefaultMethodSecurityExpressionHandler {
    private AuthenticationTrustResolver trustResolver = new AuthenticationTrustResolverImpl();

    @Override
    protected MethodSecurityExpressionOperations createSecurityExpressionRoot(Authentication authentication, MethodInvocation invocation) {
        CustomMethodSecurityExpressionRoot customMethodSecurityExpressionRoot = new CustomMethodSecurityExpressionRoot(authentication);
        customMethodSecurityExpressionRoot.setPermissionEvaluator(new CustomPermissionEvaluator());
        customMethodSecurityExpressionRoot.setTrustResolver(trustResolver); // TODO: Поменять на getter базового, проверить, отработает или нет
        customMethodSecurityExpressionRoot.setRoleHierarchy(getRoleHierarchy());
        return customMethodSecurityExpressionRoot;
    }
}

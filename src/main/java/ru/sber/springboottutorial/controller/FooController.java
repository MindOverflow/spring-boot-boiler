package ru.sber.springboottutorial.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.sber.springboottutorial.model.Foo;

@Controller
public class FooController {

    // SecurityExpressionRoot.hasPermission(Object targetId, String targetType, Object permission) ->
    // return this.permissionEvaluator.hasPermission(this.authentication, (Serializable) targetId, targetType, permission);
    @PreAuthorize(value="hasPermission(#id, 'Foo', 'read')")
    @GetMapping("/foos/{id}")
    @ResponseBody
    public Foo findById(@PathVariable long id) {
        return new Foo("Sample");
    }

    // SecurityExpressionRoot.hasPermission(Object target, Object permission) ->
    // this[SecurityExpressionRoot].permissionEvaluator.hasPermission(this.authentication, target, permission);
    //@PreAuthorize("hasPermission(#foo, 'write')")
//    @PostMapping("/foos")
//    @ResponseStatus(HttpStatus.CREATED)
//    @ResponseBody
//    public Foo create(@RequestBody Foo foo) {
//        return foo;
//    }
}
package cn.edu.gzmu.authserver.controller;

import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author <a href="https://echocow.cn">EchoCow</a>
 * @date 19-8-4 下午1:26
 */
@Controller
@SessionAttributes("authorizationRequest")
public class AuthorizationController {
    @GetMapping("/oauth/confirm_access")
    public ModelAndView getAccessConfirmation(Map<String, Object> model) {
        AuthorizationRequest authorizationRequest = (AuthorizationRequest) model.get("authorizationRequest");
        ModelAndView view = new ModelAndView();
        view.setViewName("authorization");
        view.addObject("clientId", authorizationRequest.getClientId());
        // 传递 scope 过去,Set 集合
        view.addObject("scopes", authorizationRequest.getScope());
        return view;
    }
}

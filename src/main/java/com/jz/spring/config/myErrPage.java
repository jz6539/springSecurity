package com.jz.spring.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * @author jz
 * @date 2019/11/4 - 22:20
 */
@Configuration
public class myErrPage implements ErrorPageRegistrar {
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage errorPage = new ErrorPage(HttpStatus.FORBIDDEN, "/403");
        registry.addErrorPages(errorPage);
    }
}

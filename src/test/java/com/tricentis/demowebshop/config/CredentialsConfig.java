package com.tricentis.demowebshop.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/credentials.properties",
})

public interface CredentialsConfig extends Config {

    @Key("email")
    String email();

    @Key("password")
    String password();
}
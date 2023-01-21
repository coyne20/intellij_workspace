package dev.danvega.jwtdemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@ConfigurationProperties("rsa")
public class RsaKeyProperties{

    public RSAPublicKey publicKey;
    public RSAPrivateKey privateKey;

    public RsaKeyProperties (RSAPublicKey publicKey, RSAPrivateKey privateKey){
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }

}

package com.caleblogin;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AliSmsService a = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
		a.send("java");
    }
}

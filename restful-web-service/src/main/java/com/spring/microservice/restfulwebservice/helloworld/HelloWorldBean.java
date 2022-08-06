package com.spring.microservice.restfulwebservice.helloworld;

public class HelloWorldBean {

    private String message;

    public HelloWorldBean(builder builder) {
        this.message = builder.message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class builder {
        private String message;
        public builder(String msg) {
            this.message = msg;
        }
        public HelloWorldBean build() {
            return new HelloWorldBean(this);
        }
    }
}

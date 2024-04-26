package org.hse.template.configuration

import feign.RequestInterceptor
import feign.RequestTemplate
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableFeignClients(basePackages = ["org.hse.template.client.rest.api"])
class FeignClientConfiguration {}

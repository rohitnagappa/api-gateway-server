package api.gateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class MyFilter implements GlobalFilter {

    private static final Logger logger = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // <app name, trace id , span id>
        logger.info("my filter called");
        // exchange will have req and response information
        System.out.println("nagappa pre processing logic goes here  "+exchange.getRequest());
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            System.out.println("nagappa post processing logic goes here "+exchange.getResponse());
        }));
    }
}

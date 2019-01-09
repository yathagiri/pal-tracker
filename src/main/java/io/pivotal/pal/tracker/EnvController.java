package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private String port;
    private String memorylimit;
    private String cfinstanceindex;
    private String cfinstanceaddr;

    public EnvController(@Value("${PORT:NOT SET}") String port,
                         @Value("${MEMORY_LIMIT:NOT SET}") String memorylimit,
                         @Value("${CF_INSTANCE_INDEX:NOT SET}")String cfinstanceindex,
                         @Value("${CF_INSTANCE_ADDRESS:NOT SET}")String cfinstanceaddr) {
        this.port = port;
        this.memorylimit = memorylimit;
        this.cfinstanceindex = cfinstanceindex;
        this.cfinstanceaddr = cfinstanceaddr;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv(){
        Map<String, String> env = new HashMap();
        env.put("PORT",port);
        env.put("MEMORY_LIMIT",memorylimit);
        env.put("CF_INSTANCE_INDEX",cfinstanceindex);
        env.put("CF_INSTANCE_ADDR",cfinstanceaddr);

        return env;
    }
}

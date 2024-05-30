package screensaver;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.data.util.Pair;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class PeriodicalScopeConfigure implements Scope {
    Map<String, Pair<LocalTime, Object>> map = new HashMap<>();
    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        if (map.containsKey(name)) {
            Pair<LocalTime, Object> pair = map.get(name);
            int seconds = LocalTime.now().getSecond() - pair.getFirst().getSecond();
            if (seconds > 3) {
                map.put(name, Pair.of(LocalTime.now(), objectFactory.getObject()));
            }
        } else {
            map.put(name, Pair.of(LocalTime.now(), objectFactory.getObject()));
        }
        return map.get(name).getSecond();
    }

    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}

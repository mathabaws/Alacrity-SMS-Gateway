package xyz.vukovicc.alacritysms.data;

import java.util.List;

/**
 * Created by matha on 2/4/17.
 */

public interface UserDataProvider {
    List<Trigger> getTriggers();

    List<String> getActivityLog();





}

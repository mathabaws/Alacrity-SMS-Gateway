package xyz.vukovicc.alacritysms.data;

import java.util.List;

/**
 * Created by matha on 2/4/17.
 */

public interface Trigger {

    //TODO: define setter functions

    String getAlias();
    String getType();
    String getHostname();
    Integer getHostPort();
    String getUrl();
    String getEmail();
    String getEmailHost();
    Integer getEmailPort();
    String getEmailProtocol();
    List<String> getEmailFolders();
    String getSelectedEmailFolder();
    String getUsername();
    String getPassword();
    //For future password encryption functionality
    Boolean verifyPassword();
    Boolean isActive();

}

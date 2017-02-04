package xyz.vukovicc.alacritysms.data.model;

import java.util.List;

import xyz.vukovicc.alacritysms.data.Trigger;

/**
 * Created by matha on 2/4/17.
 */

public class EmailTrigger implements Trigger {

    private String alias;
    private String type;
    private String hostname;
    private Integer HostPort;
    private String url;
    private String email;
    private String emailHost;
    private Integer emailPort;
    private String emailProtocol;
    private List<String> emailFolders;
    private String selectedEmailFolder;
    private String username;
    private String password;
    private Boolean active;


    public EmailTrigger(){
        //empty ctor
    }


    @Override
    public Boolean verifyPassword() {
        return true; //TODO: implement
    }

    @Override
    public Boolean isActive() {
        return null;
    }


    //-- Simple getters and setters ----------------------------------------------------------

    @Override
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    @Override
    public Integer getHostPort() {
        return HostPort;
    }

    public void setHostPort(Integer hostPort) {
        HostPort = hostPort;
    }

    @Override
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getEmailHost() {
        return emailHost;
    }

    public void setEmailHost(String emailHost) {
        this.emailHost = emailHost;
    }

    @Override
    public Integer getEmailPort() {
        return emailPort;
    }

    public void setEmailPort(Integer emailPort) {
        this.emailPort = emailPort;
    }

    @Override
    public String getEmailProtocol() {
        return emailProtocol;
    }

    @Override
    public List<String>getEmailFolders() {
        return emailFolders;
    }

    @Override
    public String getSelectedEmailFolder() {
        return selectedEmailFolder;
    }

    public void setEmailProtocol(String emailProtocol) {
        this.emailProtocol = emailProtocol;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setEmailFolders(List<String> emailFolders) {
        this.emailFolders = emailFolders;
    }

    public void setSelectedEmailFolder(String selectedEmailFolder) {
        this.selectedEmailFolder = selectedEmailFolder;
    }
}

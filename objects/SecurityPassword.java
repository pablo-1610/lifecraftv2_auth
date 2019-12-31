package com.kokazia.security.objects;

import java.util.UUID;

public class SecurityPassword {
    private UUID uuid;
    private String mdp;

    public SecurityPassword(UUID uuid, String mdp) {
        this.uuid = uuid;
        this.mdp = mdp;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}

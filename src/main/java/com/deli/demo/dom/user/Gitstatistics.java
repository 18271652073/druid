package com.deli.demo.dom.user;

import java.io.Serializable;
import java.util.Date;

/**
 * gitstatistics
 * @author 
 */
public class Gitstatistics implements Serializable {
    private Integer id;

    private String application;

    private String name;

    private Integer added;

    private Integer removed;

    private Integer updated;

    private Date time;

    private String status;

    private String addno;

    private Date addtime;

    private String updateno;

    private Date updatetime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAdded() {
        return added;
    }

    public void setAdded(Integer added) {
        this.added = added;
    }

    public Integer getRemoved() {
        return removed;
    }

    public void setRemoved(Integer removed) {
        this.removed = removed;
    }

    public Integer getUpdated() {
        return updated;
    }

    public void setUpdated(Integer updated) {
        this.updated = updated;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddno() {
        return addno;
    }

    public void setAddno(String addno) {
        this.addno = addno;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getUpdateno() {
        return updateno;
    }

    public void setUpdateno(String updateno) {
        this.updateno = updateno;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        return "Gitstatistics{" +
                "id=" + id +
                ", application='" + application + '\'' +
                ", name='" + name + '\'' +
                ", added=" + added +
                ", removed=" + removed +
                ", updated=" + updated +
                ", time=" + time +
                ", status='" + status + '\'' +
                ", addno='" + addno + '\'' +
                ", addtime=" + addtime +
                ", updateno='" + updateno + '\'' +
                ", updatetime=" + updatetime +
                '}';
    }
}
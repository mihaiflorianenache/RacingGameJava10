package org.fasttrackit.Domain;

public class TopWinner {

    private long id;
    private String name;
    private int wonRaces;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWonRaces() {
        return wonRaces;
    }

    public void setWonRaces(int wonRaces) {
        this.wonRaces = wonRaces;
    }

    @Override
    public String toString() {
        return "TopWinner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", wonRaces=" + wonRaces +
                '}';
    }
}

package br.com.timoteobrasil.alura.sevendays.model;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Top250Data {
    private List<Top250DataDetail> items;

    public List<Top250DataDetail> getItems() {
        return items;
    }

    public void setItems(List<Top250DataDetail> items) {
        this.items = items;
    }

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Top250Data other = (Top250Data) obj;
        return Objects.equals(items, other.items);
    }
    
}
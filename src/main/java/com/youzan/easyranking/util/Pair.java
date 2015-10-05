package com.youzan.easyranking.util;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Pair<F, S> {
    private F first; //first member of pair
    private S second; //second member of pair

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public void setFirst(F first) {
        this.first = first;
    }

    public void setSecond(S second) {
        this.second = second;
    }

    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).
          append(first).
          append(second).
          toHashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
    	   if (obj == null) { return false; }
    	   if (obj == this) { return true; }
    	   if (obj.getClass() != getClass()) {
    	     return false;
    	   }
    	   @SuppressWarnings("rawtypes")
		Pair that = (Pair) obj;
    	   return new EqualsBuilder()
    	                 .append(first, that.first)
    	                 .append(second, that.second)
    	                 .isEquals();
    }
}
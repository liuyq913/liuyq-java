package com.liuyq.jdk.util;

/**
 * Created by Administrator on 2018/4/3 0003.
 */
public class WeakHashMapTest {
   public class Element{
        private String ident;
        public Element (String id){ident = id;}
        public String toString(){return ident;}
        public int hashCode(){return ident.hashCode();}
        protected void finalize(){
            System.out.println("Finalizing"+getClass().getSimpleName()+" "+ident);

        }

       @Override
       public boolean equals(Object obj) {
           return obj instanceof Element  && ident.equals(((Element) obj).ident);
       }
   }

    class Key extends Element{
        public Key(String id){super(id);}
    }

    class Value extends Element{
        public Value(String id){super(id);}
    }


}

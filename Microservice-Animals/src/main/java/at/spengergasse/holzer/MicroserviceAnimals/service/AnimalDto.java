package at.spengergasse.holzer.MicroserviceAnimals.service;

import at.spengergasse.holzer.MicroserviceAnimals.modules.Animal;

public class AnimalDto {

    private long number;
    private String name;
    private String art;

    public void setNumber(long number){ this.number = number; }
    public long getNumber(){ return number; }
    public void setName(String name){ this.name = name; }
    public String getName(){ return name; }
    public void setArt(String art){ this.art = art; }
    public String getArt(){ return art; }

    public AnimalDto(long number, String name, String art){ this.number = number; this.name = name; this.art = art;}

    @Override
    public String toString(){ return "Animal{" + "number=" +number+ ", name="+name+", art="+art+"}"; }

    public static AnimalDto fromAnimal(Animal quote){ return new AnimalDto(quote.getNumber(), quote.getName(), quote.getArt()); }

    public Animal toAnimal(){ return Animal.builder().number(number).name(name).art(art).build(); }

    public Animal mergeWith(Animal quote){ return Animal.builder().number(getNumber()).name(name).art(art).build(); }

}

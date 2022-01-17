package at.spengergasse.holzer.MicroserviceWisdom.service;

import at.spengergasse.holzer.MicroserviceWisdom.models.Quote;

public class QuoteDto {

    private long number;
    private String text;

    public void setNumber(long number) { this.number = number; }
    public long getNumber(){ return number; }
    public void setText(String text){ this.text = text; }
    public String getText(){ return text; }

    public QuoteDto(long number, String text){ setNumber(number); setText(text); }

    @Override
    public String toString(){ return "Quote{" + "number=" +number+ ", text="+text+"}"; }

    public static QuoteDto fromQuote(Quote quote){ return new QuoteDto(quote.getNumber(), quote.getText()); }

    public Quote toQuote(){ return Quote.builder().number(number).text(text).build(); }

    public Quote mergeWith(Quote quote){ return Quote.builder().number(getNumber()).text(text).build(); }
}

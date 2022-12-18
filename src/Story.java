import characters.*;
import characters.Character;
import entities.Fire;
import myexception.UnsupportedMethod;
import places.*;

import java.util.ArrayList;

public class Story {
    public static void main(String[] args) throws UnsupportedMethod {

        Mumindalen mumindalen = new Mumindalen("Муми-дол");
        Castle castle = new Castle("Замок Короля Рубинов", mumindalen);
        Fire fire = new Fire("Огонь", castle);
        fire.flaredUp();

        Mountain mountain = new Mountain("Гора");
        Mountain peak = new Mountain("Верхушка горы");


        Wizard wizard = new Wizard("Волшебник", mountain);
        wizard.walk(mumindalen);

        Panter panter = new Panter("Пантера", peak);
        panter.jump(mountain);

        System.out.printf("Тем временем в %s:\n", mumindalen);
        RubyKing rubyKing = new RubyKing("Король Рубинов", castle);
        System.out.println(rubyKing.voiceLine());

        Mumintroll mumintroll = new Mumintroll("Муми-тролль", castle);
        FrekenSnorken frekenSnorken = new FrekenSnorken("Фрекен Снорк", castle);
        Muumimamma muumimamma = new Muumimamma("Муми-мама", castle);

        ArrayList<Character> residents = new ArrayList<>();
        residents.add(mumintroll);
        residents.add(muumimamma);
        residents.add(frekenSnorken);


        for (Character c : residents) {
            if (c == null) {
                continue;
            }
            if (c.equals(rubyKing)) {
                c.sit(rubyKing);
                c.watch(fire);
                System.out.print(c.getRemember("прошлое"));
                c.remember();
            } else {
                c.sit();
            }
        }

    }
}
import characters.*;
import entities.Fire;
import entities.Rubin;
import myexception.CantRemember;
import myexception.UnsupportedMethod;
import places.*;

import java.util.ArrayList;

public class Story {
    public static void main(String[] args) throws UnsupportedMethod {

        World world = (World) new World.Builder2("Мир").setTime().build();
        Mumindalen mumindalen = (Mumindalen) new Mumindalen.Builder2("Долина").setLocation(world).build();

        Castle castle = (Castle) new Castle.Builder2("Замок").setLocation(mumindalen).build();
        RubyKing rubyKing = new RubyKing("Король Рубинов", castle);
        Rubin rubin = new Rubin("Рубин", mumindalen, rubyKing);
        System.out.println(rubin);

        Fire fire = new Fire("Огонь", castle);
        fire.flaredUp();

        Mountain mountain = (Mountain) new Mountain.Builder2("Гора").setLocation(world).build();
        Mountain peak = (Mountain) new Mountain.Builder2("Верхушка горы").setLocation(mountain).build();


        Wizard wizard = new Wizard("Волшебник", mountain);
        wizard.walk(mumindalen);

        Panter panter = new Panter("Пантера", peak);
        panter.jump(mountain);

        System.out.printf("Тем временем в %s:\n", mumindalen);
        System.out.println(rubyKing.voiceLine());

        Mumintroll mumintroll = new Mumintroll("", castle);

        FrekenSnorken frekenSnorken = new FrekenSnorken("Фрекен Снорк", castle);
        Muumimamma muumimamma = new Muumimamma("Муми-мама", castle);

        ArrayList<Moomins> residents = new ArrayList<>();
        residents.add(mumintroll);
        residents.add(muumimamma);
        residents.add(frekenSnorken);


        for (Moomins c : residents) {
            if (c == null) {
                continue;
            }
            if (c.equals(rubyKing)) {
                c.sit(rubyKing);
                c.watch(fire);
                System.out.print(c.getRemember("прошлое"));

                try {
                    c.remember();
                } catch (CantRemember e) {
                    System.out.println(e.getMessage());
                }

            } else {
                c.sit();
            }
        }


    }
}
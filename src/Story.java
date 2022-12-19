import characters.Character;
import characters.*;
import entities.Fire;
import entities.Rubin;
import entities.Specificity;
import myexception.CantRemember;
import myexception.UnsupportedMethod;
import phrase.VoiceLinesRubyKing;
import places.*;
import utilities.CodeColor;
import utilities.Color;

import java.util.ArrayList;

public class Story {
    public static void main(String[] args) throws UnsupportedMethod {
        Moon moon = new Moon.Builder2("Луна").build();

        Wizard wizard = new Wizard("Волшебник", moon);
        Panter panter = new Panter("Пантера", moon);
        wizard.relax();
        panter.relax();

        World world = (World) new World.Builder2("Земля").setTime().build();
        Mumindalen mumindalen = (Mumindalen) new Mumindalen.Builder2("Долина").setLocation(world).build();
        Castle castle = (Castle) new Castle.Builder2("Замок").setLocation(mumindalen).build();

        RubyKing rubyKing = new RubyKing("Король Рубинов", castle);
        Rubin rubin = new Rubin(castle, rubyKing, Color.ORANGEREDCRAYOLA);
        rubyKing.voiceLine(CodeColor.RUBIN + "" + VoiceLinesRubyKing.randomStyle() + CodeColor.NONCOLOR);

        System.out.println(rubyKing);
        rubyKing.sparkling(rubin);

        wizard.watch(rubyKing);
        System.out.println(rubin);
        wizard.realized(rubin);
        wizard.gotDressed();

        wizard.shakeOut();
        wizard.saddled(panter);

        final class StarDust extends Fire implements Specificity {
            public StarDust(String name, Place location) {
                super(name, location);

            }

            public void settled(Character character) {
                int rate = -1 + (int) (Math.random() * 3);
                System.out.printf("%s %s %s.\n\n", this.getName(), (rate > 0 ? "осела на" : "пролетела мимо"), character.getName());
            }
        }

        StarDust starDust = new StarDust("Звёздная пыль", moon);

        ArrayList<Character> pair = new ArrayList<>();

        pair.add(wizard);
        pair.add(panter);

        for (Character c : pair) {
            if (c == null) {
                continue;
            }

            if (c == wizard) {
                starDust.settled(wizard);
            } else {
                c.setLocation(world);
            }

        }

        Fire fire = new Fire("Огонь", castle);
        fire.flaredUp();

        Mountain mountain = (Mountain) new Mountain.Builder2("Гора").setLocation(world).build();

        wizard.walk(mumindalen);
        panter.jump(mountain);

        System.out.printf("Тем временем в %s:\n", mumindalen);

        Mumintroll mumintroll = new Mumintroll("", castle);

        FrekenSnorken frekenSnorken = new FrekenSnorken("Фрекен Снорк", castle);
        Muumimamma muumimamma = new Muumimamma("Муми-мама", castle);

        ArrayList<Moomins> residents = new ArrayList<>();
        residents.add(mumintroll);
        residents.add(muumimamma);
        residents.add(frekenSnorken);


        for (Moomins c : residents) {
            System.out.println();
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


        for (Moomins c : residents) {
            System.out.println(c.scared());
        }

        Stranger mouse = new Stranger("Мышь", Color.WHITE);
        Stranger cat = new Stranger("Кот", Color.BLACK);

        ArrayList<Stranger> strangers = new ArrayList<>();
        strangers.add(mouse);
        strangers.add(cat);

        for (Stranger stranger : strangers) {
            if (stranger == null) {
                continue;
            }
            stranger.walk(castle);

            if (stranger == cat) {
                System.out.println(stranger.lay());
            }

        }

    }
}
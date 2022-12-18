package characters;

import entities.Entity;
import myexception.UnsupportedMethod;
import phrase.VoiceLines;
import places.Place;
import types.CodeColor;


final public class RubyKing extends Character {
    public RubyKing(String name, Place location) {
        super(name, location);
    }

    @Override
    public String getName() {
        return CodeColor.RED +super.getName() + CodeColor.NONCOLOR;
    }

    @Override
    public void jump(Place newLocation) throws UnsupportedMethod {
        throw new UnsupportedMethod();
    }

    @Override
    public void watch(Entity entity) throws UnsupportedMethod {

    }

    @Override
    public void watch(Character character) throws UnsupportedMethod {

    }


    @Override
    public void walk(Place newLocation) throws UnsupportedMethod {
        throw new UnsupportedMethod();
    }

    @Override
    public String voiceLine() {
        VoiceLines message =  VoiceLines.randomStyle();
        return "— " + CodeColor.RED + message + CodeColor.NONCOLOR + "\033[3m" + String.format(" — Сказал %s в %s", this.getName(), this.getLocation()) + " \033[0m";
    }


}

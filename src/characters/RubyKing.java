package characters;

import myexception.FellOutOfTheWorld;
import phrase.VoiceLines;
import places.Place;
import utilities.CodeColor;


final public class RubyKing extends Character {
    public RubyKing(String name, Place location) {
        super(name, location);
    }

    @Override
    public String getName() {
        return CodeColor.RED + super.getName() + CodeColor.NONCOLOR;
    }

    @Override
    public void walk(Place newLocation) {
        String message;
        if (newLocation == null) {
            throw new FellOutOfTheWorld(this.getName());
        } else {
            message = String.format("%s побежал в %s! ", this.getName(), newLocation.getName());
            this.setLocation(newLocation);
        }
        System.out.print(message);
    }


    public void Sparkling() {

    }

    public String voiceLine() {
        VoiceLines message = VoiceLines.randomStyle();
        return "— " + CodeColor.RED + message + CodeColor.NONCOLOR + "\033[3m" + String.format(" — Сказал %s в %s", this.getName(), this.getLocation()) + " \033[0m";
    }

}

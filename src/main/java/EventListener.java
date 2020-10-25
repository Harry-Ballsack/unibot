package main.java;

import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRoleAddEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRoleRemoveEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class EventListener extends ListenerAdapter {

    public static final String guildID = "740916429951598683";
    public static final Guild guild = MainBot.jda.getGuildById(guildID);
    public static final TextChannel botcommands = guild.getTextChannelById("753640254917050579");
    public static final TextChannel botkonsole = guild.getTextChannelById("765256872936079401");
    public static final TextChannel module = guild.getTextChannelById("764937703691124736");
    public static final TextChannel social = guild.getTextChannelById("769920466994855946");


    public void msg(String msg){
        botkonsole.sendMessage(msg).queue();
    }


    @Override
    public void onPrivateMessageReceived(PrivateMessageReceivedEvent event) {

        if (event.getAuthor().equals(MainBot.jda.getSelfUser()))
            return;

        befehlAusfuehren(event.getAuthor(), event.getMessage());

    }

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        if (event.getAuthor().equals(MainBot.jda.getSelfUser()))
            return;

        if (!event.getChannel().equals(botcommands))
            return;

        befehlAusfuehren(event.getAuthor(), event.getMessage());

    }


    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event){

        if (event.getUser().equals(MainBot.jda.getSelfUser()))
            return;

        if (event.getTextChannel().getId().equals("764935334366019594"))          //Regeln und Welcome
            Rollen.regelnadd(event);

        else if (event.getTextChannel().getId().equals("769930976012795906"))          //Welcome
            Rollen.welcomeadd(event);

        else if (event.getTextChannel().getId().equals("764937703691124736"))           //Modulechannel
            Rollen.moduleadd(event);

        else if (event.getTextChannel().getId().equals("769920466994855946"))           //social-rollen
            Rollen.socialadd(event);

    }

    @Override
    public void onMessageReactionRemove(MessageReactionRemoveEvent event){

        if (event.getUser().equals(MainBot.jda.getSelfUser()))
            return;

        if (event.getTextChannel().getId().equals("764935334366019594"))         //Regeln
            Rollen.regelnrem(event);

        else if (event.getTextChannel().getId().equals("769930976012795906"))         //Welcome
            Rollen.welcomerem(event);

        else if (event.getTextChannel().getId().equals("764937703691124736"))         //Modulechannel
            Rollen.modulerem(event);

        else if (event.getTextChannel().getId().equals("769920466994855946"))         //social-rollen
            Rollen.socialrem(event);

    }

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event){
        
        EventListener.guild.addRoleToMember(event.getMember(), EventListener.guild.getRoleById("769931144221163550")).queue();

    }

    @Override
    public void onGuildMemberRoleAdd(GuildMemberRoleAddEvent event) {

        if (event.getRoles().contains(guild.getRoleById("768143973511987241"))) {                               //Sem. 1
            guild.addRoleToMember(event.getMember(), guild.getRoleById("764937834863001610")).queue();
            guild.addRoleToMember(event.getMember(), guild.getRoleById("764938020688101426")).queue();
            guild.addRoleToMember(event.getMember(), guild.getRoleById("764938234253672478")).queue();
            guild.addRoleToMember(event.getMember(), guild.getRoleById("764938237109075988")).queue();
            guild.addRoleToMember(event.getMember(), guild.getRoleById("764938239558942740")).queue();
        }

        else if (event.getRoles().contains(guild.getRoleById("769590160886857770"))) {                               //Sem. 2
            guild.addRoleToMember(event.getMember(), guild.getRoleById("769900641895055360")).queue();
            guild.addRoleToMember(event.getMember(), guild.getRoleById("769900644579540993")).queue();
            guild.addRoleToMember(event.getMember(), guild.getRoleById("769900647394181120")).queue();
            guild.addRoleToMember(event.getMember(), guild.getRoleById("769900649109258271")).queue();
            guild.addRoleToMember(event.getMember(), guild.getRoleById("769900651655462922")).queue();
        }

        else if (event.getRoles().contains(guild.getRoleById("768143954449268768"))) {                                //Sem. 3
            guild.addRoleToMember(event.getMember(), guild.getRoleById("768142504145977384")).queue();
            guild.addRoleToMember(event.getMember(), guild.getRoleById("768143242150674452")).queue();
            guild.addRoleToMember(event.getMember(), guild.getRoleById("768143269694799903")).queue();
            guild.addRoleToMember(event.getMember(), guild.getRoleById("768143272731213825")).queue();
            guild.addRoleToMember(event.getMember(), guild.getRoleById("768143275340333076")).queue();
        }

        else if (event.getRoles().contains(guild.getRoleById("769590166213754920"))) {                               //Sem. 4
            guild.addRoleToMember(event.getMember(), guild.getRoleById("769900654431830037")).queue();
            guild.addRoleToMember(event.getMember(), guild.getRoleById("769900655900360735")).queue();
            guild.addRoleToMember(event.getMember(), guild.getRoleById("769900657817288705")).queue();
            guild.addRoleToMember(event.getMember(), guild.getRoleById("769900659427901450")).queue();
            guild.addRoleToMember(event.getMember(), guild.getRoleById("769900660794851348")).queue();
            guild.addRoleToMember(event.getMember(), guild.getRoleById("769900662371647488")).queue();
            guild.addRoleToMember(event.getMember(), guild.getRoleById("769900663852236800")).queue();

        }
    }

    @Override
    public void onGuildMemberRoleRemove(GuildMemberRoleRemoveEvent event){

        if (event.getRoles().contains(guild.getRoleById("768143973511987241"))) {                               //Sem. 1
            guild.removeRoleFromMember(event.getMember(), guild.getRoleById("764937834863001610")).queue();
            guild.removeRoleFromMember(event.getMember(), guild.getRoleById("764938020688101426")).queue();
            guild.removeRoleFromMember(event.getMember(), guild.getRoleById("764938234253672478")).queue();
            guild.removeRoleFromMember(event.getMember(), guild.getRoleById("764938237109075988")).queue();
            guild.removeRoleFromMember(event.getMember(), guild.getRoleById("764938239558942740")).queue();
        }

        else if (event.getRoles().contains(guild.getRoleById("769590160886857770"))) {                               //Sem. 2
            guild.removeRoleFromMember(event.getMember(), guild.getRoleById("769900641895055360")).queue();
            guild.removeRoleFromMember(event.getMember(), guild.getRoleById("769900644579540993")).queue();
            guild.removeRoleFromMember(event.getMember(), guild.getRoleById("769900647394181120")).queue();
            guild.removeRoleFromMember(event.getMember(), guild.getRoleById("769900649109258271")).queue();
            guild.removeRoleFromMember(event.getMember(), guild.getRoleById("769900651655462922")).queue();
        }

        else if(event.getRoles().contains(guild.getRoleById("768143954449268768"))) {                                //Sem. 3
            guild.removeRoleFromMember(event.getMember(), guild.getRoleById("768142504145977384")).queue();
            guild.removeRoleFromMember(event.getMember(), guild.getRoleById("768143242150674452")).queue();
            guild.removeRoleFromMember(event.getMember(), guild.getRoleById("768143269694799903")).queue();
            guild.removeRoleFromMember(event.getMember(), guild.getRoleById("768143272731213825")).queue();
            guild.removeRoleFromMember(event.getMember(), guild.getRoleById("768143275340333076")).queue();
        }

        else if (event.getRoles().contains(guild.getRoleById("769590166213754920"))) {                               //Sem. 4
            guild.removeRoleFromMember(event.getMember(), guild.getRoleById("769900654431830037")).queue();
            guild.removeRoleFromMember(event.getMember(), guild.getRoleById("769900655900360735")).queue();
            guild.removeRoleFromMember(event.getMember(), guild.getRoleById("769900657817288705")).queue();
            guild.removeRoleFromMember(event.getMember(), guild.getRoleById("769900659427901450")).queue();
            guild.removeRoleFromMember(event.getMember(), guild.getRoleById("769900660794851348")).queue();
            guild.removeRoleFromMember(event.getMember(), guild.getRoleById("769900662371647488")).queue();
            guild.removeRoleFromMember(event.getMember(), guild.getRoleById("769900663852236800")).queue();
        }

    }

    public void befehlAusfuehren(User user, Message message){

        Commands commands = Commands.eval(message.getContentRaw());
        MessageBuilder messageBuilder = new MessageBuilder();

        switch (commands){

            case hallo:
                messageBuilder.setContent("Hallo, ich bin ein Bot und kann mitlerweile schon einiges :)");
                break;

            case termine:
                messageBuilder.setContent("Das Termin-feature ist noch in der Entwicklung");
                break;

            case help:
                Ausgaben.help(user);
                return;

            case unknown:
                //messageBuilder.setContent("Unbekannter Befehl, sryyyyy OwO");
                return;

            case stundenplan:
                Ausgaben.stundenplan(user);
                return;

        }

         user.openPrivateChannel().queue(channel -> channel.sendMessage(messageBuilder.build()).queue());

    }

}

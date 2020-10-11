import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

import javax.security.auth.login.LoginException;
import java.awt.*;

public class MainBot {

    public static final String BOT_TOKEN = "NzUzNjEzMjM5MjcwNTA2NTE3.X1ovBQ.Y9LPSiKGzF6Opt44G9wu-mKJMBI";
    public static JDA jda;

    public static void main(String[] args) {


        try{
            JDABuilder builder = JDABuilder.createDefault(BOT_TOKEN);
            builder.enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_VOICE_STATES, GatewayIntent.GUILD_EMOJIS, GatewayIntent.DIRECT_MESSAGES, GatewayIntent.GUILD_PRESENCES, GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MESSAGE_REACTIONS);
            builder.setActivity(Activity.watching("you"));
            builder.setChunkingFilter(ChunkingFilter.ALL);
            builder.setMemberCachePolicy(MemberCachePolicy.ALL);
            jda = builder.build();
            jda.awaitReady();
            jda.addEventListener(new EventListener());
        } catch (LoginException | InterruptedException ignored){}

        startMessageBot();
        //testNachricht();


    }

    public static void startMessageBot() {

        EmbedBuilder eb = new EmbedBuilder();

        eb.setAuthor("Uni-Bot_EIT");
        eb.setTitle("Hallo, ich bin der Uni-Bot dieses Discords.\n\nMit !help, !h und !hilfe (entweder privat an mich direkt oder im bot-command Channel), bekommst du eine private nachricht mit all meinen Befehelen");
        eb.addField("", "bei Fragen oder anregungen bezüglich mir richte dich an meinen Schöpfer <@411138870793469952> oder andere mit der <@&753639586110111755> Rolle.",false);
        eb.setThumbnail("https://secure.meetupstatic.com/photos/event/2/5/0/f/highres_456969487.jpeg");
        eb.setColor(Color.blue);

        MessageEmbed me = eb.build();

        EventListener.guild.getTextChannelById("764937566926536775").sendMessage(me).queue();

    }

    public static void testNachricht(){
        EventListener.guild.getTextChannelById("753640621855604908").sendMessage("https://cdn.discordapp.com/attachments/753618061092847729/761288403261587476/Fachsemester_1_Stundenplan-1.jpg").queue();
    }

}

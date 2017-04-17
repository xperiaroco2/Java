import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;


public class Bot {
    final String[] COMMON_PHRASES = {
            "Зараз би піваса...",
            "Не хочеш бахнути по тетереві?))",
            "В сімьорке такий топчик ...",
            "ебать я вчора ригав ..",
            "гоу в п'ятницю Нажремся?)))))))",
            "Я люблю електроніку как Влад біоніку..как Влад біоніку ..",
            "Зараз би хуй Димаса....."
    };
    final String[] ELUSIVE_ANSWERS = {
            "Ооой, не зайобуй",
            "Я хз",
            "Ти доїбатися вирішив?"
    };
    final Map<String, String> PATTERNS_FOR_ANALYSIS = new HashMap<String,String>(){
        {
            //hi
            put("хай", "hi");
            put("здорова", "hi");
            put("привет", "hi");
            //who
            put("кто\\s.*ты", "who");
            put("ты\\s.*кто", "who");
            //howareyou
            put("как\\s.*дела", "howareyou");
            put("как\\s.жизнь", "howareyou");
            put("как\\s.*жизулька", "howareyou");
            put("как\\s.*оно", "howareyou");
            //name
            put("как\\s.*зовут", "name");
            put("как\\s.*имя", "name");
            put("есть\\s.*имя", "name");
            put("какое\\s.*имя", "name");
            put("как\\s.*звать", "name");
            put("есть\\s.*кликуха", "name");
            //whatdoyoudoing
            put("зачем\\s.*тут", "whatdoyoudoing");
            put("зачем\\s.*здесь", "whatdoyoudoing");
            put("что\\s.*делаешь", "whatdoyoudoing");
            put("чем\\s.*занимаешься", "whatdoyoudoing");
            put("чем\\s.*занят", "whatdoyoudoing");
            put("шо\\s.*делаешь", "whatdoyoudoing");
            put("нахуй\\s.*тут", "whatdoyoudoing");
            //whatdoyoulike
            put("что\\s.*нравится", "whatdoyoulike");
            put("что\\s.*любишь", "whatdoyoulike");
            //imfeelling
            put("кажется", "imfeelling");
            put("чувствую", "imfeelling");
            put("испытываю", "imfeelling");
            put("думаю", "imfeelling");
            //yes
            put("^да", "yes");
            put("согласен", "yes");
            put("^ага", "yes");
            put("^точно", "yes");
            //whattime
            put("который\\s.*час", "whattime");
            put("сколько\\s.*времени", "whattime");
            put("шо\\s.*времени", "whattime");
            put("что\\s.*времени", "whattime");
            //bye
            put("прощай", "bye");
            put("увидимся", "bye");
            put("пока", "bye");
            //fuck
            put("иди нахуй", "fuck");
            put("соси хуй", "fuck");
            //plata
            put("плата", "plata");
            //pidor
            put("пидор", "pidor");
        }};
    final Map<String,String> ANSWERS_BY_PATTERNS = new HashMap<String,String>(){{
       put("hi","Ну привіт..");
       put("who","Я алкаш.....та електронщик");
       put("name","Ярослав");
       put("howareyou","Голова досі болить після вчорашнього...");
       put("whatdoyoulike","Бухлішко та плату))0");
       put("imfeelling","Та мені пофіг");
       put("yes","Дадада");
       put("bye","Давай удачі, а я в магаз за бухлішком))");
       put("fuck","Йди нахуй");
       put("yes","Дадада");
       put("plata","О даааа....плата)");
       put("pidor","Може досить?");
    }};

    Pattern pattern;
    Random random;
    Date date;





    Bot(){
        random = new Random();
        date = new Date();
    }




    String sayInReturn(String msg, boolean ai) {
        String say = (msg.trim().endsWith("?"))?
                ELUSIVE_ANSWERS[random.nextInt(ELUSIVE_ANSWERS.length)]:
                COMMON_PHRASES[random.nextInt(COMMON_PHRASES.length)];
        if(ai){
            String message =
                    String.join(" ", msg.toLowerCase().split("[ {,|.?]"));
            for(Map.Entry<String, String> o : PATTERNS_FOR_ANALYSIS.entrySet()){
                pattern = Pattern.compile(o.getKey());
                if(pattern.matcher(message).find())
                    if(o.getValue().equals("whattime")) return "Чай йти бухати, але ось - "+date.toString();
                else return ANSWERS_BY_PATTERNS.get(o.getValue());
            }
        }
        return say;
    }
}

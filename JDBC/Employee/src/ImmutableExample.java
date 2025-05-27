public final class ImmutableExample {

    private final String panCard;

    ImmutableExample(String panCard){
        this.panCard = panCard;
    }

    public String getPanCard(){
        return panCard;
    }


    public static void main(String[] args) {

        ImmutableExample immutableExample = new ImmutableExample("1498rhfa");

        System.out.println(immutableExample.getPanCard());


    }


}

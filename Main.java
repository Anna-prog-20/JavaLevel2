public class Main {

    public static void main(String[] args) {
		Members members[]=new Members[3];
		members[0]=new Person("Вася",60,10,5);
		members[1]=new Cat("Барсик","Белый",20,1);
		members[2]=new Robot("Питер",50,15);
		Obstacle obstacle[]=new Obstacle[2];
		obstacle[0]=new Racetrack(15);
		obstacle[1]=new Wall(3);
		passObstacle(obstacle,members);
    }
    static void passObstacle(Obstacle obstacle[],Members members[]){
		for (int j=0;j<members.length;j++)
			for (int i=0;i<obstacle.length;i++)
			{
				if (obstacle[i].getClass().getTypeName()=="Racetrack")
					obstacle[i].run(members[j]);
				else
					obstacle[i].jump(members[j]);
			}
	}

}

package ag;

import jade.core.AID;
import jade.core.Agent;
import jade.core.Location;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;

public class Mentor extends Agent {
	private static final long serialVersionUID = 1L;
	private String livre;

	@Override
	protected void setup() {
		Object[] args = getArguments();
		System.out.println("je suis l'agent :" + this.getName());
		if (args.length > 0) {
			livre = (String) args[0];
			System.out.println("j'asiste mes Etudiants");

		} else {
			doDelete();
		}
		ACLMessage sms = new ACLMessage(ACLMessage.INFORM_REF);
		sms.addReceiver(new AID("Systeme", AID.ISLOCALNAME));
		sms.setContent("Demande de login -----Mentor");
		send(sms);
		this.addBehaviour(new CyclicBehaviour() {
			private static final long serialVersionUID = 1L;
			private int compteur = 0;

			@Override
			public void action() {
				++compteur;
				System.out.println("<<<<<<<<<<<<<<<<<<<" + compteur + ">>>>>>>>>>>>>>>>>>>>");

				ACLMessage sms = myAgent.receive();
				if (sms == null) {
					this.block();
				} else {
					ACLMessage sms1 = new ACLMessage(ACLMessage.INFORM);
					sms1.addReceiver(sms.getSender());
					sms1.setContent("Merci Bonjours");
					send(sms);
					System.out.println("<<<<<<<<<<<<<<<00<<<<" + sms.getContent() + ">>>>>>>>>>>>>>>>>>>>");
				}
			}

		});
		this.addBehaviour(new TickerBehaviour(this, 5000) {

			private static final long serialVersionUID = 1L;
			private int compteur = 0;

			@Override
			protected void onTick() {
//				++compteur;
//				ACLMessage sms = new ACLMessage(ACLMessage.INFORM);
//				sms.addReceiver(new AID("Malik", AID.ISLOCALNAME));
//				sms.setContent("Bonjours");
//				send(sms);
//				System.out.println("<<<<<<<<<<<<<<<<<<< je veux acheter le livre " + compteur + ">>>>>>>>>>>>>>>>>>>>");

			}

		});
		super.setup();
	}

	@Override
	protected void takeDown() {
		System.out.println("je suis fini :" + this.getName());

		super.takeDown();
	}

	@Override
	public void doMove(Location arg0) {
		System.out.println("Depart pour  :" + arg0.getName());

	}

}

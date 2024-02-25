package ag;

import jade.core.Agent;
import jade.core.Location;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;

public class Systeme extends Agent {
	private static final long serialVersionUID = 1L;
	private String livre;

	@Override
	protected void setup() {
		Object[] args = getArguments();
		System.out.println("je suis l'agent :" + this.getName());
		if (args.length > 0) {
			livre = (String) args[0];
			System.out.println("je controle les interactions");

		} else {
			doDelete();
		}

		this.addBehaviour(new CyclicBehaviour() {
			private static final long serialVersionUID = 1L;

			@Override
			public void action() {

				ACLMessage sms = myAgent.receive();
				if (sms == null) {
					this.block();
				} else {
					if (sms.getPerformative() == ACLMessage.INFORM_REF) {
						ACLMessage sms1 = new ACLMessage(ACLMessage.INFORM_REF);
						sms1.addReceiver(sms.getSender());
						sms1.setContent("authentification reussi vous pouvez utiliser les services du systeme");
						send(sms1);
						System.out.println("message d'un Agent " + sms.getContent() + ">>>>>>>>>>>>>>>>>>>>");
					}
//					ACLMessage sms1 = new ACLMessage(ACLMessage.INFORM);
//					sms1.addReceiver(sms.getSender());
//					sms1.setContent("Merci Bonjours");
//					send(sms);
//					System.out.println("<<<<<<<<<<<<<<<00<<<<" + sms.getContent() + ">>>>>>>>>>>>>>>>>>>>");
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

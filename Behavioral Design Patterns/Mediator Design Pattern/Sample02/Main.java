interface ChatRoomMediator {
    public void showMessage(User user, String message);
}

// Mediator
class ChatRoom implements ChatRoomMediator {
    public void showMessage(User user, string message) {
		System.out.println("[" + user.getName() + "]: " + message);
    }
}

class User {
    protected String name;
    protected ChatRoomMediator chatMediator;

    public User(String name, ChatRoomMediator chatMediator) {
        this.name = name;
        this.chatMediator = chatMediator;
    }

    public String getName() {
        return this.name;
    }

    public void send(message) {
        this.chatMediator.showMessage(this, message);
    }
}

public class Main {
	public static void main(String[] args) {
		ChatRoomMediator mediator = new ChatRoom();

		User john = new User('John Doe', mediator);
		User jane = new User('Jane Doe', mediator);

		john.send('Hi there!');
		jane.send('Hey!');
	}
}
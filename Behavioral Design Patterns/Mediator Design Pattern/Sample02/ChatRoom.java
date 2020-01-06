class ChatRoom implements ChatRoomMediator {
    public void showMessage(User user, string message) {
		System.out.println("[" + user.getName() + "]: " + message);
    }
}
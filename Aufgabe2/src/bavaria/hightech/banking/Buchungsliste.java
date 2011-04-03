package bavaria.hightech.banking;

public class Buchungsliste {
	private ListElement head = new ListElement(null, null);
	private ListElement current = head;

	public void add(Buchung buchung) {
		ListElement element = new ListElement(buchung, null);
		if (head.next == null) {
			head.next = element;
		} else {
			ListElement currentElement = head.next;
			while (currentElement.next != null) {
				currentElement = currentElement.next;
			}
			currentElement.next = element;
		}
	}

	public Buchung next() {
		if (current.next == null) {
			return null;
		}
		current = current.next;
		return current.data;
	}

	public void resetIteration() {
		current = head;
	}

	public void clear() {
		head.next = null;
		resetIteration();
	}

	private class ListElement {
		Buchung data;
		ListElement next;

		ListElement(Buchung data, ListElement next) {
			this.data = data;
			this.next = next;
		}
	}
}

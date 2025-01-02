public class CustomerList {
    public Customer head;

    public CustomerList() {
        head = null;
    }

    public void add(Customer customer) {
        if (head == null || customer.number.compareTo(head.number) < 0) {
            customer.next = head;
            head = customer;
        } else {
            Customer current = head;
            while (current.next != null && customer.number.compareTo(current.next.number) > 0) {
                current = current.next;
            }
            customer.next = current.next;
            current.next = customer;
        }
    }

    public Customer findCustomerByPhoneNumber(String phoneNumber) {
        Customer current = head;
        while (current != null) {
            if (current.number.equals(phoneNumber)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Used this for testing
    public void allCustomers() {
        Customer current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }
}

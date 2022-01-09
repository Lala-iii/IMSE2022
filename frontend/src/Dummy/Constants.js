export const transactions = [
  {
    from: "Muhi",
    receiver: {
      firstname: "Muhammed",
      lastname: "Akinci",
      iban: "AT16 3333 4444 5555 6666 77",
      birthdate: "14.10.1993",
    },
    ttype: "normal",
    category: "Groceries",
    reference: "Groceries 12/21",
    amount: 150,
  },
  {
    sender: "Lala",
    receiver: {
      firstname: "Kerim",
      lastname: "Akinci",
      iban: "AT16 2342 2322 5456 4566 77",
      birthdate: "07.07.2008",
    },
    ttype: "foreign",
    category: "Rent",
    reference: "Rent 12/21",
    amount: 200,
  },
  {
    sender: "Lala",
    receiver: {
      firstname: "Muhammed",
      lastname: "Akinci",
      iban: "AT16 3333 4444 5555 6666 77",
      birthdate: "14.10.1993",
    },
    ttype: "self",
    category: "Groceries",
    reference: "Groceries 12/21",
    amount: 260,
  },
  {
    sender: "David",
    receiver: {
      firstname: "Fatih",
      lastname: "Alioglu",
      iban: "AT16 1234 2222 5555 2342 99",
      birthdate: "08.09.1988",
    },
    ttype: "normal",
    category: "Rent",
    reference: "Rent 12/21",
    amount: 300,
  },
  {
    sender: {
      firstname: "Muhammed",
      lastname: "Akinci",
      iban: "AT16 3333 4444 5555 6666 77",
      birthdate: "14.10.1993",
    },
    receiver: {
      firstname: "Kerim",
      lastname: "Akinci",
      iban: "AT16 2342 2322 5456 4566 77",
      birthdate: "07.07.2008",
    },
    ttype: "repeating",
    category: "Savings",
    reference: "Saving for trip",
    amount: 400,
  },
];
export const persons = [
  {
    firstname: "Muhammed",
    lastname: "Akinci",
    iban: "AT16 3333 4444 5555 6666 77",
    birthdate: "14.10.1993",
  },
  {
    firstname: "Kerim",
    lastname: "Akinci",
    iban: "AT16 2342 2322 5456 4566  77",
    birthdate: "07.07.2008",
  },
  {
    firstname: "Fatih",
    lastname: "Alioglu",
    iban: "AT16 1234 2222 5555 2342 99",
    birthdate: "08.09.1988",
  },
];

export const iban = [
  {
    firstname: "Muhammed",
    lastname: "Akinci",
    iban: "AT16 1234 2222 5555 2342 99",
    account_type: "Savings",
  },
  {
    firstname: "Muhammed",
    lastname: "Akinci",
    iban: "AT16 2342 2322 5456 4566 77",
    account_type: "Giro",
  },
  {
    firstname: "Muhammed",
    lastname: "Akinci",
    iban: "AT16 3333 4444 5555 6666 77",
    account_type: "Second Account",
  },
];

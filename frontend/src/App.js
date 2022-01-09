import logo from "./logo.svg";
import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Navbar from "./Components/Navbar";
import LandingPage from "./Pages/LandingPage";
import CreateAccount from "./Pages/CreateAccount";
import CreateTransaction from "./Pages/CreateTransaction";
import ShowTransactions from "./Pages/ShowTransactions";
import Settings from "./Pages/Settings";
import Contacts from "./Pages/Contacts";

function App() {
  return (
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route exact path="/" element={<LandingPage />} />
        <Route exact path="/createAccount" element={<CreateAccount />} />
        <Route
          exact
          path="/createTransaction"
          element={<CreateTransaction />}
        />

        <Route exact path="/Contacts" element={<Contacts />} />
        <Route exact path="/showTransactions" element={<ShowTransactions />} />
        <Route exact path="/settings" element={<Settings />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;

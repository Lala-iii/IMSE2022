import logo from "./logo.svg";
import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Navbar from "./Components/Navbar";
import LandingPage from "./Pages/LandingPage";
import CreateAccount from "./Pages/CreateAccount";
import CreateTransaction from "./Pages/CreateTransaction";
import ShowTransactions from "./Pages/ShowTransactions";
import Customers from "./Pages/Customers";

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

        <Route exact path="/Customers" element={<Customers />} />
        <Route exact path="/showTransactions" element={<ShowTransactions />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;

import React from 'react';
import { Link } from 'react-router-dom';
import './styles.css';
function Navbar() {
  return (
    <nav>
      <div className="nav-left">
        <Link to="/">Home</Link>
      </div>
      <div className="nav-right">
        <ul>
          <li>
            <Link to="/create">Add event</Link>
          </li>
          <li>
            <Link to="/list">List event</Link>
          </li>
          <li>
            <Link to="/update">Update event</Link>
          </li>
          <li>
            <Link to="/delete">Delete event</Link>
          </li>
        </ul>
      </div>
    </nav>
  );
}

export default Navbar;

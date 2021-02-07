import React, { Component } from 'react';
import Dashboard from './modules/Dashboard/Dashboard';

class App extends Component {
  render() {
    return (
      <div className="container-fluid">
        <div className="jumbotron">
          <h1>Order tickets</h1>
          <p>An application that allows users to order tickets for landmarks and events.</p>
        </div>
        <Dashboard />
      </div>
    );
  }
}

export default App;

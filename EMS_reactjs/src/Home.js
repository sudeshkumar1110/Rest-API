import React from 'react';

function Home() {
  const containerStyle = {
    background: `url('https://content.jdmagicbox.com/comp/seoni/b4/9999p7695.7695.221221192903.f5b4/catalogue/j-and-d-events-seoni-city-seoni-fun-n-fair-organisers-2gc58jwx8y.jpg')`,
    backgroundSize: 'cover',
    padding: '20px',
    fontFamily: 'fantacy',
    textAlign: 'center',
    color: 'tomato', // Set text color to white for better visibility on a background imagem
  };

  const h1Style = {
    fontSize: '36px', // You can adjust the font size as needed
  };

  return (
    <div style={containerStyle}>
      <h1 style={h1Style}>Welcome to Event Management System</h1>
      <p>
        Event management is the application of project management to the creation and development of small and/or large-scale personal or corporate events such as festivals, conferences, ceremonies, weddings, formal parties, concerts, or conventions.
      </p>
    </div>
  );
}

export default Home;

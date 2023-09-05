import React, { useEffect, useState } from 'react';
import axios from 'axios';
// import './crudStyles.css'; // Import the CSS file for styling
import './styles.css';

function ListEvents() {
  const [events, setEvents] = useState([]);
  useEffect(() => {
    const fetchEvents = async () => {
      try {
        const response = await axios.get('http://localhost:8080/showevent');
        if (response.status === 200) {
          setEvents(response.data); // Use response.data to access the parsed JSON
        } else {
          console.error('Error:', response.statusText);
        }
      } catch (error) {
        console.error('Error:', error);
      }
    };
    fetchEvents();
  }, []);

  return (
    <div className='crud'  style={{backgroundColor:"tomato"}}>
      <h2 style={{ fontFamily: 'monospace', color: 'black' }}>Event List</h2>
      {events.map((event, index) => (
        <div
          key={index}
          style={{
            backgroundColor: 'white',
            border: '1px solid #ccc',
            boxShadow: '2px 2px 4px rgba(0, 0, 0, 0.1)',
            padding: '10px',
            margin: '10px',
            fontFamily: 'monospace',
            color: 'black',
          }}
        >
          <h4>Customer Name: {event.customerName}</h4>
          <p>Event Type: {event.eventType}</p>
          <p>Event Date: {event.eventDate}</p>
          <p>Event Budget: {event.eventBudget}</p>
          {event.vd && (
            <div
              style={{
                backgroundColor: 'lightgray',
                padding: '10px',
                boxShadow: '2px 2px 4px rgba(0, 0, 0, 0.1)',
              }}
            >
              <h4>Venue: {event.vd.venue}</h4>
              {event.vd.ser && event.vd.ser.length > 0 && (
                <>
                  <h5>Services:</h5>
                  <ul>
                    {event.vd.ser.map((service, serviceIndex) => (
                      <li
                        key={serviceIndex}
                        style={{
                          backgroundColor: 'lightblue',
                          padding: '5px',
                          boxShadow: '2px 2px 4px rgba(0, 0, 0, 0.1)',
                        }}
                      >
                        <p>Service ID: {service.serviceId}</p>
                        <p>Provider Name: {service.providerName}</p>
                      </li>
                    ))}
                  </ul>
                </>
              )}
            </div>
          )}
        </div>
      ))}
    </div>
  );
}

export default ListEvents;

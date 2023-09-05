import React, { useState } from 'react';
// import './crudStyles.css'; // Import the CSS file for styling
import './styles.css';
import axios from 'axios';

function AddEvent() {
  const [customerName, setCustomerName] = useState('');
  const [eventType, setEventType] = useState('');
  const [eventDate, setEventDate] = useState('');
  const [eventBudget, setEventBudget] = useState(null);
  const [venue, setVenue] = useState('');
  const [providerName, setProviderName] = useState('');
  const [serviceId, setServiceId] = useState(null);

  const handleSubmit = async (e) => {
    e.preventDefault();
    const eventData = {
      customerName,
      eventType,
      eventDate,
      eventBudget,
      vd: {
        venue,
        ser: [{
          serviceId,
          providerName,
        }]
      }
    };

    try {
      console.log(eventData);
      const response = await axios.post(`http://localhost:8080/addevent`, eventData);
      console.log(response.data);

      if (response.status === 200) {
        setCustomerName('');
        setEventType('');
        setEventDate('');
        setEventBudget(0);
        setVenue('');
        setProviderName('');
        setServiceId(1);

        // Display a success alert message
        window.alert('Data added successfully!');
      } else {
        // Display an error message
        window.alert('Error adding data. Please try again later.');
      }
    } catch (error) {
      console.error('Error:', error);
      // Display a user-friendly error message
      window.alert('An error occurred. Please try again later.');
    }
  };

  return (
    <div className='crud'>
      <h2>Add Event</h2>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="customerName">Customer Name:</label>
          <input
            type="text"
            id="customerName"
            placeholder="Customer Name"
            value={customerName}
            onChange={(e) => setCustomerName(e.target.value)}
          />
        </div>
        <div className="form-group">
          <label htmlFor="eventType">Event Type:</label>
          <input
            type="text"
            id="eventType"
            placeholder="Event Type"
            value={eventType}
            onChange={(e) => setEventType(e.target.value)}
          />
        </div>
        <div className="form-group">
          <label htmlFor="eventDate">Event Date:</label>
          <input
            type="date"
            id="eventDate"
            placeholder="Event Date"
            value={eventDate}
            onChange={(e) => setEventDate(e.target.value)}
          />
        </div>
        <div className="form-group">
          <label htmlFor="eventBudget">Event Budget:</label>
          <input
            type="number"
            id="eventBudget"
            placeholder="Event Budget"
            value={eventBudget}
            onChange={(e) => setEventBudget(e.target.value)}
          />
        </div>
        <div className="form-group">
          <label htmlFor="venue">Venue:</label>
          <input
            type="text"
            id="venue"
            placeholder="Venue"
            value={venue}
            onChange={(e) => setVenue(e.target.value)}
          />
        </div>
        <div className="form-group">
          <label htmlFor="providerName">Service Provider Name:</label>
          <input
            type="text"
            id="providerName"
            placeholder="Service Provider Name"
            value={providerName}
            onChange={(e) => setProviderName(e.target.value)}
          />
        </div>
        <div className="form-group">
          <label htmlFor="serviceId">Service ID:</label>
          <input
            type="number"
            id="serviceId"
            placeholder="Service ID"
            value={serviceId}
            onChange={(e) => setServiceId(e.target.value)}
          />
        </div>
        <button type="submit">Add</button>
      </form>
    </div>
  );
}

export default AddEvent;

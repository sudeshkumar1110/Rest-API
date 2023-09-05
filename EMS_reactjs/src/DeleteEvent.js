import React, { useState } from 'react';
import axios from 'axios';
// import './crudStyles.css'; // Import the CSS file for styling
import './styles.css';

function DeleteEvent() {
  const [eventId, setEventId] = useState(null);
  const [deleteMessage, setDeleteMessage] = useState('');

  const handleEventIdChange = (e) => {
    setEventId(e.target.value);
  };

  const handleDelete = async (e) => {
    try {
      const response = await axios.delete(`http://localhost:8080/delid/${eventId}`);
      if (response.status === 200) {
        // Event deleted successfully, update the message
        setDeleteMessage('Event deleted successfully.');
      } else {
        // Handle the error case
        setDeleteMessage('Error: Failed to delete event.');
      }
    } catch (error) {
      console.error('Error:', error);
      setDeleteMessage('Error: Failed to delete event. Please check your network connection.');
    }
  };

  return (
    <div className='crud'>
      <h2>Delete Event by Event ID</h2>
      <input
        type="number"
        placeholder="Event ID"
        value={eventId}
        onChange={handleEventIdChange}
      />
      <button onClick={handleDelete}>Delete</button>
      <p>{deleteMessage}</p>
    </div>
  );
}

export default DeleteEvent;

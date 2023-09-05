import React, { useState } from 'react';
// import './crudStyles.css'; // Import the CSS file for styling
import './styles.css';
import axios from 'axios';
function UpdateEvent() {
  const [oldEventId, setOldEventId] = useState(null);
  const [newEventId, setNewEventId] = useState(null);

  const handleUpdate =  async(e) => {
    e.preventDefault();
    try {
      const response =  await axios.put(`http://localhost:8080/updatebyjpqa/${oldEventId}/${newEventId}`);
      console.log(response.data);
      if (response.status === 200) {
        setOldEventId(null);
        setNewEventId(null);
        // Display a success alert message
        window.alert('Data updated successfully!');
      } else {
        // Display an error message
        window.alert('Error updating data. Please try again later.');
      }
    } catch (error) {
      console.error('Error:', error);
      // Display a user-friendly error message
      window.alert('An error occurred. Please try again later.');
    }
  };

  return (
    <div className='crud'>
      <h2>Update Event</h2>
      <form onSubmit={handleUpdate}>
        <div className="form-group">
          <label htmlFor="oldEventId">Old Event ID:</label>
          <input
            type="number"
            id="oldEventId"
            placeholder="Old Event ID"
            value={oldEventId}
            onChange={(e) => setOldEventId(e.target.value)}
          />
        </div>
        <div className="form-group">
          <label htmlFor="newEventId">New Event ID:</label>
          <input
            type="number"
            id="newEventId"
            placeholder="New Event ID"
            value={newEventId}
            onChange={(e) => setNewEventId(e.target.value)}
          />
        </div>
        <button type="submit">Update</button>
      </form>
    </div>
  );
}

export default UpdateEvent;

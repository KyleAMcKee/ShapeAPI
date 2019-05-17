import React, { useState, useEffect } from 'react';
import ShapeTable from './ShapeTable';
import AddShapeForm from './AddShapeForm';
import EditShapeForm from './EditShapeForm';

const App = () => {
  const initialFormState = { id: null, label: '', labelRow: '', rows: '', type: '' }

  const [shapes, setShapes] = useState([]);
  const [loading, setLoading] = useState(true);
  const [editing, setEditing] = useState(false);
  const [currentShape, setCurrentShape] = useState(initialFormState)
  const [display, setDisplay] = useState(false);
  const [displayShape, setDisplayShape] = useState(null);

  //const proxy = "https://cors-anywhere.herokuapp.com/";
  const proxy = ''
  //const url = "https://shielded-shelf-21827.herokuapp.com/shapes/";
  const url = 'http://localhost:8080/shapes/';

async function fetchData() {
    try {
        const response = await fetch(proxy + url);
        const data = await response.json();
        setShapes(data);
    } catch (e) {
        console.error(e);
    }
    setLoading(false);
};

  useEffect(() => {
    fetchData();
  }, []);

  const addShape = async shape => {
    if (!shape.rows || !shape.type ) return;
    shape.label = shape.label.replace(/[^0-9a-z]/gi, '');
    const body = JSON.stringify({type: shape.type, rows: shape.rows, label: shape.label || "HI", labelRow: shape.labelRow || 4});
    await fetch(proxy + url, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: body
    });
    fetchData();
  }

  const deleteShape = id => {
    fetch(proxy + url + '/' + id, {
      method: 'DELETE',
      headers: {
        'Content-Type': 'application/json'
      },
    });
    let displayId = currentShape.id
    setShapes(shapes.filter(shape => shape.id !== id));
    if (id === displayId) {
      setDisplay(false);
    }
  }

  const updateShapeForm = shape => {
    setDisplay(true)
    setEditing(true);
    setDisplayShape(shape);
    setCurrentShape({ id: shape.id, type: shape.type, rows: shape.height, label: shape.label, labelRow: shape.labelRow })
  }

  const updateShape = async (id, shape) => {
    setEditing(false);
    shape.label = shape.label.replace(/[^0-9a-z]/gi, '');
    const body = JSON.stringify({type: shape.type, rows: shape.rows, label: shape.label || "HI", labelRow: shape.labelRow || 4});
    await fetch(proxy + url + '/' + id, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json'
      },
      body: body
    });
    fetchData();
  }

  const showShape = (shape) => {
    setDisplay(true)
    setDisplayShape(shape);
  }

  const renderShape = () => {
    let shape = displayShape.model;
    return shape.map((row, idx) => <div key={idx} style={{whiteSpace: 'pre'}}>{row}</div>);
  }

  return (
    <div className="container">
      <h1>Shape API</h1>
      <div className="flex-row">
        <div className="flex-large">
          {editing ? (
            <div>
            <h2>Edit Shape</h2>
            <EditShapeForm
              editing={editing}
              setEditing={setEditing}
              currentShape={currentShape}
              updateShape={updateShape}
            />
        </div>
      ) : (
        <div>
          <h2>Add Shape</h2>
          <AddShapeForm addShape={addShape} />
        </div>
      )}
      </div>
        <div className="flex-large">
          <h2>View Shapes</h2>
          {loading ? <div>loading...</div> : <ShapeTable shapes={shapes} updateShapeForm={updateShapeForm} deleteShape={deleteShape} showShape={showShape}/>}
        </div>
      </div>
      <div className="flex-row">
        <div className="flex-large">
          <h2>Display Shape</h2>
          {display ? <div style={{fontFamily: 'monospace, monospace'}}>{renderShape()}</div> : <div>Click show to display a shape</div>}
        </div>
      </div>
    </div>
  )
}

export default App;

//auto render on update
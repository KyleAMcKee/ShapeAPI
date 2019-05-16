import React, { useState } from 'react'

const AddShapeForm = props => {
    const initialFormState = { label: '', labelRow: '', rows: '', type: '' }
    const [shape, setShape] = useState(initialFormState);

    const handleInputChange = event => {
        const { name, value } = event.target;
        setShape({ ...shape, [name]: value });
    }

    const handleSubmit = (event) => {
        event.preventDefault();
        props.addShape(shape);
    }

    return (
        <form onSubmit={handleSubmit}>
            <label>Label</label>
            <input type="text" name="label" value={shape.label} onChange={handleInputChange}/>
            <label>Label Row</label>
            <input min="1" max="30" type="number" name="labelRow" value={shape.labelRow} onChange={handleInputChange} />
            <label>Rows</label>
            <input min="1" max="30" type="number" name="rows" value={shape.rows} onChange={handleInputChange} />
            <label>Type</label>
            <input type="text" name="type" value={shape.type} onChange={handleInputChange} />
            <button type="submit">Add new shape</button>
        </form>
    )
}

export default AddShapeForm
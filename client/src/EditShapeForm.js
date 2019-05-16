import React, { useState, useEffect } from 'react'

const EditShapeForm = props => {
  const [shape, setShape] = useState(props.currentShape)

  const handleInputChange = event => {
    const { name, value } = event.target
    setShape({ ...shape, [name]: value })
  }

  useEffect(() => {
    setShape(props.currentShape)
  }, [props])

  const handleSubmit = (event) => {
        event.preventDefault();
        props.updateShape(shape.id, shape);
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
        <input type="text" name="type" value={shape.type} disabled/>
      <button type="submit">Update Shape</button>
      <button onClick={() => props.setEditing(false)} className="button muted-button">Cancel</button>
    </form>
  )
}

export default EditShapeForm
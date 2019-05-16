import React from 'react'

const ShapeTable = props => (
  <table>
    <thead>
      <tr>
        <th>Shape</th>
        <th>Label</th>
        <th>Rows</th>
        <th>Label Row</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
        {props.shapes.length > 0 ? (
            props.shapes.map(shape => (
            <tr key={shape.id}>
                <td>{shape.type}</td>
                <td>{shape.label}</td>
                <td>{shape.height}</td>
                <td>{shape.labelRow}</td>
                <td>
                    <button onClick={() => props.updateShapeForm(shape)} className="button muted-button">Edit</button>
                    <button onClick={() => props.deleteShape(shape.id)} className="button delete-button">Delete</button>
                    <button onClick={() => props.showShape(shape)} className="button accent-button">Show</button>
                </td>
            </tr>
            ))
        ) : (
            <tr>
            <td colSpan={3}>No Shapes</td>
            </tr>
        )}
    </tbody>
  </table>
)

export default ShapeTable
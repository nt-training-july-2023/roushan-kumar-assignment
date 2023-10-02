import React from 'react'

function Button({
    id,
    name,
    className,
    onClick,
    type,
    value,
}) {
    return (
        <>
            <button
                id={id}
                name={name}
                className={className}
                onClick={onClick}
                type={type}
                value={value}
            >
                {name}
            </button>
        </>
    )
}

export default Button